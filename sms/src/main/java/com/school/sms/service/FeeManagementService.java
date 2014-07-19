package com.school.sms.service;

import java.util.List;

import com.school.sms.model.DiscountsAndConcessions;
import com.school.sms.model.FixedFeeBatchYearMonth;
import com.school.sms.model.VariableFeeBatchYearMonth;

public interface FeeManagementService {

	public void addFixedFeeStructure();
	public List<FixedFeeBatchYearMonth> loadFeeStructures();
    public void updateFixedFee(FixedFeeBatchYearMonth feeBatchYearMonth);
    public FixedFeeBatchYearMonth findFixedFee(String session,Integer batchId,String month);
	public VariableFeeBatchYearMonth findVariableFee(String session,
			String batch, String month, String studentNameClassRoll);
	public void updateVariableFee(VariableFeeBatchYearMonth variableFee);
	public List<VariableFeeBatchYearMonth> loadVariableFeeStructures();
	public List<DiscountsAndConcessions> loadDiscountsAndConcession();
	public DiscountsAndConcessions findDiscountsAndConcession(String parameter,
			String valueOf, String parameter2, String parameter3);
	public void updateDiscountsAndConcession(
			DiscountsAndConcessions discountsAndConcession);
	public void deleteVariableFee(VariableFeeBatchYearMonth variableFee);
	public void deleteFixedFee(FixedFeeBatchYearMonth fixedFee);
}
