import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.helper.CowinAPIService;
import org.example.models.StateResponse;
import org.example.models.State;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StateTests {

    private CowinAPIService cowinAPIService;
    private StateResponse stateResponse;

    @BeforeClass
    public void init() {
        cowinAPIService = new CowinAPIService();
        stateResponse = cowinAPIService.getAllStates();
    }

    @Test
    void testStateId() throws JsonProcessingException {

        int stateId = 16;
        String stateName = "Karnataka";

        boolean check = false;
        for (State state : stateResponse.getStates()) {
            if (state.getState_name().equals(stateName)) {
                if (state.getState_id() == stateId) {
                    check = true;
                    break;
                }

            }
        }
        Assert.assertTrue(check);
    }

    @Test
    void testStateIdIsNotNull() throws JsonProcessingException {

        for (State state : stateResponse.getStates()) {
            if (state.getState_name() != null) {
                Assert.assertNotNull(state.getState_id(), "A State with stateId == null is found");
            }
        }
    }
}