package scheduler.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

import scheduler.model.InstanceInfo;
import scheduler.model.MachineInfo;
import scheduler.plugins.Scheduler;

public class SchedulerMain {

	public static void main(String[] args) throws IOException {
		Map<String, String> bindMap = new HashMap<String, String>();
		
		// init: process json file
		
		List<MachineInfo> mList = processMachines();
		
		List<InstanceInfo> iList = processInstances();
		
		List<Scheduler> sList = new ArrayList<Scheduler>();
		
		bindMap = processScheduler(mList, iList, sList);
		
		// output to file
		writeToFile(bindMap);
		
	}
	
	// process scheduler
	private static Map<String, String> processScheduler(List<MachineInfo> mList, List<InstanceInfo> iList, List<Scheduler> sList) {
		
		return null;
	}
	
	
	// process machine
	private static List<MachineInfo> processMachines() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("/Users/lvhonglei/works/scheduler/scheduling_preliminary_machine_info_20180607.json")));
		
		Set<String> resSet = new HashSet<String>();
		String line = null;
		while ((line = br.readLine()) != null) {
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> macMap = mapper.readValue(line, Map.class);
			
			String key = macMap.keySet().iterator().next();
			
			Map<String, Object> mMap = (Map<String, Object>) macMap.get(key);
			
			Map<String, Integer> resMap = (Map<String, Integer>) mMap.get("resources");
			
			resSet.add(resMap.get("cpu") + "-" + resMap.get("mem") + "-" + resMap.get("disk_size"));
			
			
		}
		
		System.out.println(resSet.size());
		
		for (String key : resSet) {
			System.out.println(key);
		}
		
		
		return null;
	}
	
	// process instance
	private static List<InstanceInfo> processInstances() {
		
		return null;
	}
	
	// output to bindMap
	private static void writeToFile(Map<String, String> bindMap)  {
		
	}

}
