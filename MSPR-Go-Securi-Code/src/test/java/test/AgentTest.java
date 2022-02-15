package test;

import models.Agent;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AgentTest {

    @Test
    void addItemToAgent() {
        Agent agent = new Agent("test", "test", "test","test.txt","aerty", new ArrayList<String>());
        String item = "lampe";
        agent.addItemToAgent(item);
        assertEquals(agent.getItemList().get(0), item);
    }

    @Test
    void generateAgentFile() {
    }
}