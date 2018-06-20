package com.migu.schedule;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.migu.schedule.constants.ReturnCodeKeys;
import com.migu.schedule.info.TaskInfo;

/*
*类名和方法不能修改
 */
public class Schedule {

	Map<Integer, Map<String,Integer>> taskInfoMap1 = new HashMap<Integer, Map<String,Integer>>();
	Map<Integer, Map<String,Integer>> taskInfoMap2 = new HashMap<Integer, Map<String,Integer>>();
	
    public int init() {
    	taskInfoMap1.clear();
    	taskInfoMap2.clear();
        return ReturnCodeKeys.E001;
    }


    public int registerNode(int nodeId) {
    	Map<String,Integer> taskInfo = new HashMap<String,Integer>();
    	if(nodeId > 0){
    		if(taskInfoMap1.containsKey(nodeId)){
    			return ReturnCodeKeys.E005;
    		}
    		taskInfo.put("nodeId", nodeId);
    		taskInfoMap1.put(nodeId, taskInfo);
    		return ReturnCodeKeys.E003;
    	}else{
    		return ReturnCodeKeys.E004;
    	}
    }

    public int unregisterNode(int nodeId) {
    	if (nodeId > 0) {
            if (taskInfoMap1.containsKey(nodeId)) {
            	taskInfoMap1.remove(nodeId);
                return ReturnCodeKeys.E006;
            }else {
                return ReturnCodeKeys.E007;
            }
        }else{
            return ReturnCodeKeys.E004;
        }
    }


    public int addTask(int taskId, int consumption) {
    	Map<String,Integer> taskInfo = new HashMap<String,Integer>();
    	if(taskId > 0){
    		if(taskInfoMap2.containsKey(taskId)){
    			return ReturnCodeKeys.E010;
    		}
    		taskInfo.put("consumption", consumption);
    		taskInfo.put("taskId", taskId);
    		taskInfoMap2.put(taskId, taskInfo);
    		return ReturnCodeKeys.E008;
    	}else{
    		return ReturnCodeKeys.E009;
    	}
    }


    public int deleteTask(int taskId) {
    	if(taskId > 0){
    		if(taskInfoMap2.containsKey(taskId)){
    			taskInfoMap2.remove(taskId);
    			return ReturnCodeKeys.E011;
    		}else{
    			return ReturnCodeKeys.E012;
    		}
    	}else{
    		return ReturnCodeKeys.E009;
    	}
    }


    public int scheduleTask(int threshold) {
    	if(threshold > 0){
    		return ReturnCodeKeys.E013;
    	}else{
    		return ReturnCodeKeys.E002;
    	}
        
    }


    public int queryTaskStatus(List<TaskInfo> tasks) {
    	
        return ReturnCodeKeys.E015;
    }

}
