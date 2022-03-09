package test;

import models.Agent;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AgentTest {

    @Test
    void addItemToAgent() {
        Agent agent = new Agent("test", "test", "test", "test.txt", new ArrayList<String>());
        String item = "lampe";
        agent.addItemToAgent(item);
        assertEquals(agent.getItemList().get(0), item);
    }

    @Test
    void generateAgentFile() {
    }

    /**
     * This test will test that two hash with the same password ar the same;
     */
    @Test
    void passwordToSha1TestTrue(){
        List<String> list = null;
        Agent  agent = new Agent("toto", "test","test","password", list);
        String hash = agent.getHash();
        Agent  agent1 = new Agent("tata", "titi","test","password", list);
        String hash2 = agent1.getHash();

        assertEquals(hash, hash2);
    }
}