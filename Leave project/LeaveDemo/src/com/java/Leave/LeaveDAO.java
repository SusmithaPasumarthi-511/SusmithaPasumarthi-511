package com.java.Leave;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class LeaveDAO {
	static List<LeaveDetails> LeaveDetailsList;
	static {
		LeaveDetailsList=new ArrayList<>();
	}
	public String addLeave(LeaveDetails leaveDetails) {
		
		leaveDetails.setLeaveAppliedOn(new Date(0));
		 long ms = leaveDetails.getLeaveEndDate().getTime() -
				 leaveDetails.getLeaveStartDate().getTime();
		    long m = ms / (1000 * 24 * 60 * 60);
		    int days = (int) m;
		    days = days + 1;
		    leaveDetails.setNoOfDays(days);
		    return "Leave Added Successfully...";
	}
	
	public String AddLeaveDao(LeaveDetails ld)
	{
		LeaveDetailsList.add(ld);
		return "Leave Details Successfully Added";
	}
	
	public List<LeaveDetails> ShowLeaveDetailsDao()
	{
		return LeaveDetailsList;
	}
	
	public String deleteLeaveDao(int id)
	{
		for (LeaveDetails leaveDetails : LeaveDetailsList) 
		{
			if(leaveDetails.getLeaveId()==id)
			{
				LeaveDetailsList.remove(leaveDetails);
				return "deleted Successfully";
			}
		}
		return "No record Found";
	}
	
	public LeaveDetails searchLeaveDao(int id)
	{
		for (LeaveDetails leaveDetails : LeaveDetailsList) 
		{
			if(leaveDetails.getLeaveId()==id)
			{
				return leaveDetails;
			}
		}
		return null;
	}
	
	public String updatedetails(LeaveDetails ob)
	{
		for (LeaveDetails leaveDetails : LeaveDetailsList) {
			if(leaveDetails.getLeaveId()==ob.getLeaveId())
			{
				leaveDetails.setLeaveStartDate(ob.getLeaveStartDate());
				leaveDetails.setLeaveEndDate(ob.getLeaveEndDate());
				leaveDetails.setEmpId(ob.getEmpId());
				leaveDetails.setNoOfDays(ob.getNoOfDays());
				leaveDetails.setLeaveAppliedOn(ob.getLeaveAppliedOn());
				leaveDetails.setLeaveReason(ob.getLeaveReason());
				return "Successfully updated";
			}
		}
		return "No record Found";
	}

}
