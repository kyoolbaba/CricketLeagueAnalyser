package com.ipl;

import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {
    public enum IplSheet{RUNSHEET,WICKETSHEET}
    private IplSheet sheet;
    Map<String, IplRunSheetDAO> sheetMap =null;
    public CricketLeagueAnalyser(IplSheet sheet){
        this.sheet=sheet;
    }
    public  int loadRunsSheetData(String csvFilePath) throws CricketLeagueAnalyserException {
        sheetMap=IplAdapterFactory.getCensusData(csvFilePath,sheet);
        return sheetMap.size();
    }

    public String getAverageWiseSortedData() throws CricketLeagueAnalyserException {
        Comparator<IplRunSheetDAO> iplCSVComparator =Comparator.comparing(sortBy->sortBy.average);
        return sort(iplCSVComparator);
    }

    public String getStrikeRateWiseSortedData() throws CricketLeagueAnalyserException {
        Comparator<IplRunSheetDAO> iplCSVComparator =Comparator.comparing(sortBy->sortBy.strikeRate);
        return sort(iplCSVComparator);
    }

    public String getSixesWiseSortedData() throws CricketLeagueAnalyserException {
        Comparator<IplRunSheetDAO> iplCSVComparator =Comparator.comparing(sortBy->sortBy.sixes);
        return sort(iplCSVComparator);
    }

    public String getFoursWiseSortedData() throws CricketLeagueAnalyserException {
        Comparator<IplRunSheetDAO> iplCSVComparator =Comparator.comparing(sortBy->sortBy.fours);
        return sort(iplCSVComparator);
    }

    public String getStrikeRateWiseWithSixesAndFoursSortedData() throws CricketLeagueAnalyserException {
        Comparator<IplRunSheetDAO> iplCSVCompareByFoursSixesAndStrikeRate =Comparator.comparing(sortBy->sortBy.combinationOfFoursSixesAndStriteRate);
        return sort(iplCSVCompareByFoursSixesAndStrikeRate);
    }

    public String getSixesAndFoursWiseSortedData() throws CricketLeagueAnalyserException {
        Comparator<IplRunSheetDAO> iplCSVCompareByFoursAndSixes =Comparator.comparing(sortBy->sortBy.combinationOfFoursAndSixes);
        return sort(iplCSVCompareByFoursAndSixes);
    }

    public String getBestCombinationOfAverageAndStrikeRate() throws CricketLeagueAnalyserException {
        Comparator<IplRunSheetDAO> iplCSVCompareByStrikeRateAndAverage =Comparator.comparing(sortBy->sortBy.combinationOfStrikeRateAndAverage);
        return sort(iplCSVCompareByStrikeRateAndAverage);
    }

    public String getBestCombinationRunsAndAverage() throws CricketLeagueAnalyserException {
        Comparator<IplRunSheetDAO> iplCSVCompareByRunsAndAverage =Comparator.comparing(sortBy->sortBy.combinationOfRunsWithAverage);
        return sort(iplCSVCompareByRunsAndAverage);
    }

    public String sort(Comparator cricketLeagueCSV) throws CricketLeagueAnalyserException {
        if(sheetMap ==null || sheetMap.size()==0){
            throw new CricketLeagueAnalyserException("No League Data",
                    CricketLeagueAnalyserException.ExceptionType.DATA_NOT_APPROPRIATE);
        }
        List sortedDataByColumn= (List) sheetMap.values().stream().
                sorted(cricketLeagueCSV).collect(Collectors.toList());
        String sortedDataInJson=new Gson().toJson(sortedDataByColumn);
        return sortedDataInJson;
    }
}
