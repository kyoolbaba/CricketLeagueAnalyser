package com.ipl;

import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    public enum IplSheet{RUNSHEET,WICKETSHEET}
    public enum CompareBy{
    COMPARE_BY_AVERAGE,COMPARE_BY_STRIKERATE,COMBINAITON_OF_4AND6,COMBINATION_OF_STRIKERATE_AND6AND4,
        COMBINATION_OF_STRIKERATE_WITH_AVERAGE,COMBINATION_OF_RUNS_WITH_BEST_AVERAGES,
        COMPARE_BY_BOWLINGAVERAGE,COMPARE_BY_BOWLINGSTRIKERATE,COMPARE_BY_BESTECONOMY,
        COMBINATION_OF_BESTSTRIKERAT_EWITH4AND5WICKETS,COMBINAITON_WITH_BOWLINGAVERAGEWITHMAX_WICKETS,
        COMBINATION_OF_BOWLINGAVERAGE_WITH_STRIKERATE,
        BEST_BATTING_AND_BOWLING_AVERAGES,ALLROUNDERS
    }
    private IplSheet sheet;
    Map<String, IplSheetDAO> sheetMap =null;
    public CricketLeagueAnalyser(IplSheet sheet){
        this.sheet=sheet;
    }
    
    public  int loadRunsSheetData(String ... csvFilePath) throws CricketLeagueAnalyserException {
        sheetMap=IplAdapterFactory.getIPLData(sheet,csvFilePath);
        return sheetMap.size();
    }

    public String compareBy(CompareBy compareBy) throws CricketLeagueAnalyserException {
        Comparator<IplSheetDAO> compareByComparator= CompareBySorting.getComparatorforSorting(compareBy);
        if(sheetMap ==null || sheetMap.size()==0){
            throw new CricketLeagueAnalyserException("No League Data",
                    CricketLeagueAnalyserException.ExceptionType.DATA_NOT_APPROPRIATE);
        }
        List sortedDataByColumn= (List) sheetMap.values().stream().
                sorted(compareByComparator).collect(Collectors.toList());
        String sortedDataInJson=new Gson().toJson(sortedDataByColumn);
        return sortedDataInJson;
    }


}
