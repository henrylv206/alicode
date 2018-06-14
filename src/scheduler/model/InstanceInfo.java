package scheduler.model;

import java.util.Set;

public class InstanceInfo {

	String instance_id;
	
	Integer cpu; // C
	Integer mem; // M
	Integer disk_size; // M
	
	Set<String> match_tag;
	Set<String> exclude_tag;
	Set<String> exclusive_tag;
	
	Boolean is_key_instance;
	
	String app_group;
	
	String host_id;

	
	public String getInstance_id() {
		return instance_id;
	}

	public void setInstance_id(String instance_id) {
		this.instance_id = instance_id;
	}

	public Integer getCpu() {
		return cpu;
	}

	public void setCpu(Integer cpu) {
		this.cpu = cpu;
	}

	public Integer getMem() {
		return mem;
	}

	public void setMem(Integer mem) {
		this.mem = mem;
	}

	public Integer getDisk_size() {
		return disk_size;
	}

	public void setDisk_size(Integer disk_size) {
		this.disk_size = disk_size;
	}

	public Set<String> getMatch_tag() {
		return match_tag;
	}

	public void setMatch_tag(Set<String> match_tag) {
		this.match_tag = match_tag;
	}

	public Set<String> getExclude_tag() {
		return exclude_tag;
	}

	public void setExclude_tag(Set<String> exclude_tag) {
		this.exclude_tag = exclude_tag;
	}

	public Set<String> getExclusive_tag() {
		return exclusive_tag;
	}

	public void setExclusive_tag(Set<String> exclusive_tag) {
		this.exclusive_tag = exclusive_tag;
	}

	public Boolean getIs_key_instance() {
		return is_key_instance;
	}

	public void setIs_key_instance(Boolean is_key_instance) {
		this.is_key_instance = is_key_instance;
	}

	public String getApp_group() {
		return app_group;
	}

	public void setApp_group(String app_group) {
		this.app_group = app_group;
	}

	public String getHost_id() {
		return host_id;
	}

	public void setHost_id(String host_id) {
		this.host_id = host_id;
	}
	
	
	
}
