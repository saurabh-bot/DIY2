import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.helper.CowinAPIService;
import org.example.models.District;
import org.example.models.DistrictResponse;
import org.example.models.Session;
import org.example.models.SessionResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;

public class DistrictTests {
    private CowinAPIService cowinAPIService;

    @BeforeClass
    public void init() {
        cowinAPIService = new CowinAPIService();
    }

    @Test
    void testDistrictId() throws JsonProcessingException {

        String districtName = "Bangalore Urban";
        int districtId = 265;
        int stateId = 16;

        DistrictResponse districtResponse = cowinAPIService.getDistricts(stateId);
        boolean check = false;
        for (District district : districtResponse.getDistricts()) {
            if (district.getDistrict_name().equals(districtName) && district.getDistrict_id() == districtId) {
                check = true;
                break;
            }
        }
        Assert.assertTrue(check == true, "District id of " + districtName + " is not " + districtId);
    }


    @Test
    void testMaxFeeOfADistrict() throws JsonProcessingException {

        String hospitalName = "Springleaf Healthcare";
        int districtId = 265;
        String stateName = "Karnataka";
        String districtName = "Bangalore Urban";
        int maxFee = 300;

        SessionResponse sessionResponse = cowinAPIService.getHospitalsOfADistrict(districtId, new Date());
        boolean check = false;

        for (Session session : sessionResponse.getSessions()) {
            if (session.getName().equals(hospitalName) && session.getState_name().equals(stateName) && session.getDistrict_name().equals(districtName)) {
                if (Double.parseDouble(session.getFee()) > maxFee) {
                    check = true;
                    break;
                }
            }
        }
        Assert.assertTrue(check == true, "Maximum fee of " + districtName + " is not greater than  " + maxFee);
    }

    @Test
    void testFreeCentreInADistrict() throws JsonProcessingException {

        String districtName = "Bangalore Urban";
        int districtId = 265;

        SessionResponse sessionResponse = cowinAPIService.getHospitalsOfADistrict(districtId, new Date());

        boolean free = false;
        for (Session session : sessionResponse.getSessions()) {
            if (session.getDistrict_name().equals(districtName)) {
                if (Integer.parseInt(session.getFee()) == 0) {
                    free = true;
                    break;
                }
            }

        }
        Assert.assertTrue(free == true, "No free centres in " + districtName + " found today");
    }
}
