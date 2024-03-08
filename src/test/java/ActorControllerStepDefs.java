import com.example.sakilatest.controllers.ActorController;
import com.example.sakilatest.entities.Actor;
import com.example.sakilatest.services.ActorService;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertNotNull;

public class ActorControllerStepDefs {

    private ActorService mockService;

    private Actor actualActor;

    @Before
    public void setup(){
        mockService = mock(ActorService.class);
    }

    @Given("the actor with id {short} exists")
    public void givenActorExists(short id){

        Actor expectedActor1 = new Actor((short) 1, "PENELOPE", "GUINESS");
        Actor expectedActor2 = new Actor((short) 5, "JOHNNY", "LOLLOBRIGIDA");
        Actor expectedActor3 = new Actor((short) 13, "UMA", "WOOD");
        Actor expectedActor4 = new Actor((short) 53, "MENA", "TEMPLE");
        Actor expectedActor5 = new Actor((short) 79, "MAE", "HOFFMAN");

        doReturn(expectedActor1).when(mockService).getById((short) 1);
        doReturn(expectedActor2).when(mockService).getById((short) 5);
        doReturn(expectedActor3).when(mockService).getById((short) 13);
        doReturn(expectedActor4).when(mockService).getById((short) 53);
        doReturn(expectedActor5).when(mockService).getById((short) 79);
    }

    @When("a get request is made to actor {short}")
    public void getRequestMade(short id){
        final ActorController controller = new ActorController(mockService);
        try{
            actualActor = controller.getActorByID(id);
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }

    @Then("the returned actor should have name {string} {string}")
    public void correctActorReturned(String firstName, String lastName){
        assertNotNull(actualActor);
        assertEquals(firstName, actualActor.getFirstName());
        assertEquals(lastName, actualActor.getLastName());
    }

}
