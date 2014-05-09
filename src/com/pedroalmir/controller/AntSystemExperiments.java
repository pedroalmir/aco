/**
 * 
 */
package com.pedroalmir.controller;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.pedroalmir.model.graph.Graph;
import com.pedroalmir.model.problem.AntConfiguration;
import com.pedroalmir.model.solution.Solution;

/**
 * @author Pedro Almir
 */
public class AntSystemExperiments {
	
	/** Result folder */
	public static final String RESULT_FOLDER = "C:/Users/Pedro Almir/git/aco/results/xls/";
	
	@Test
	public void executeQuestionOne(){
		Graph graph = DataFactory.createGraphOfQuestionOne();
		/* Blank workbook */
        XSSFWorkbook workbook = new XSSFWorkbook();
		for(AntConfiguration config : DataFactory.createConfigurationsOfQuestionOne()){
			AntSystemControllerTSP controllerTSP = new AntSystemControllerTSP(graph, graph.getNodes().get(1), config);
			Solution solution = controllerTSP.execute();
			if(solution != null){
				System.out.println(solution.toString());
				
				/* Create a blank sheet */
				XSSFSheet sheet = workbook.createSheet(config.getAlgorithmName());
				List<Object[]> lines = solution.printThis();
				PlotSolution.writeSheet(workbook, sheet, lines);
			}
		}
		PlotSolution.writeWorkbook(workbook, RESULT_FOLDER, "questionOne.xlsx");
		//solution.printThis(RESULT_FOLDER + "questionOne_" + config.getStrategy() + ".csv");
	}
}
