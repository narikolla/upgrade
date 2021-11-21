package upgradetest;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.restassured.response.Response;

public class UpgradeAPITests extends BaseTest {

	ClassLoader classLoader = null;

	@BeforeClass
	public void initializeTest() {
		classLoader = getClass().getClassLoader();
	}

	/*
	 * This test is. for basic authentication check using API token
	 */
	@Test
	public void testStates() throws JSONException, JsonParseException, JsonMappingException, IOException {
		Response res = RESTASSURED_REQUEST.log().all().get("/states");
		Assert.assertEquals(res.getStatusCode(), 200, " Response code is not matching ");
		JSONObject obj = new JSONObject(res.getBody().asString());
		JSONArray stateList = (JSONArray) obj.get("states");
		Assert.assertEquals(stateList.length(), 48, "State count is same ");
		Assert.assertEquals(res.getStatusCode(), 200, " Failed to load the states");

		com.fasterxml.jackson.databind.ObjectMapper objMapper = new com.fasterxml.jackson.databind.ObjectMapper();
		List<State> states = objMapper.readValue(stateList.toString(),
				objMapper.getTypeFactory().constructCollectionType(List.class, State.class));
		int minAgeCount = 0;
		int stateWithMinLoanAmt = 0;
		for (int i = 0; i < states.size(); i++) {
			State state = states.get(i);

			if (state.getMinAge() == 19) {
				minAgeCount++;
				System.out.println("THE STATE WITH MINIMUM AGE OF 19 is : " + state.getLabel());
			}

			if (state.getMinLoanAmount() == 3005) {
				System.out.println("THE STATE With Min Amount of 3005 is : " + state.getLabel());
				stateWithMinLoanAmt++;
				Assert.assertEquals(state.getLabel(), "Georgia");
			}
		}

		Assert.assertEquals(minAgeCount, 1, "There are more than one state with minimum age of 19");
		Assert.assertEquals(stateWithMinLoanAmt, 1, "There are more than one state with minimum amunt of $3,005");

	}

}
