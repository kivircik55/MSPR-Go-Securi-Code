package models;

import java.util.Map;
//import org.apache.commons.codec.digest.Crypt;

/**
 * Class which represent a thread who will create an agent file.
 */
public class AgentThread implements Runnable{
    private final int threadId;
    private final Map<String, String> inventoryFileMap;
    private final Agent agent;

    /**
     * Constructor of the agent thread which take an id that will be the index of the agent on the list, the
     * whole inventory map of the company and the agent to create.
     *
     * @param threadId Id of the thread who will be the index of the agent list.
     * @param inventoryFileMap The entire inventory map of the company in list.txt
     * @param agent The agent to create his page on the site.
     */
    public AgentThread(int threadId, Map<String, String> inventoryFileMap, Agent agent) {
        this.threadId = threadId;
        this.inventoryFileMap = inventoryFileMap;
        this.agent = agent;
    }

    /**
     * Override of the run method that will launch the creation of the site.
     */
    @Override
    public void run() {
        if (this.agent == null || this.inventoryFileMap == null){
            assert this.agent != null;
            System.out.println("The specified agent "+ this.agent.toString()+" has not been created cause of null.");
        }else{
            this.agent.generateAgentFile(this.inventoryFileMap);
            System.out.println("Thread #"+threadId+" has created the agent file : "+ this.agent.getLogin());
        }

    }
}
