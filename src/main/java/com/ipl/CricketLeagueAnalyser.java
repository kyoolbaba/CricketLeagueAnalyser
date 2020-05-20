package com.ipl;

import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    public enum IplSheet{RUNSHEET,WICKETSHEET}
    private IplSheet sheet;
    Map<String, IplSheetDAO> sheetMap =null;
    public CricketLeagueAnalyser(IplSheet sheet){
        this.sheet=sheet;
    }
    public  int loadRunsSheetData(String ... csvFilePath) throws CricketLeagueAnalyserException {
        sheetMap=IplAdapterFactory.getCensusData(sheet,csvFilePath);
        return sheetMap.size();
    }

    public String getAverageWiseSortedData() throws CricketLeagueAnalyserException {
        Comparator<IplSheetDAO> iplCSVComparator =Comparator.comparing(sortBy->sortBy.average);
        return sort(iplCSVComparator);
    }

    public String getStrikeRateWiseSortedData() throws CricketLeagueAnalyserException {
        Comparator<IplSheetDAO> iplCSVComparator =Comparator.comparing(sortBy->sortBy.strikeRate);
        return sort(iplCSVComparator);
    }

    public String getSixesWiseSortedData() throws CricketLeagueAnalyserException {
        Comparator<IplSheetDAO> iplCSVComparator =Comparator.comparing(sortBy->sortBy.sixes);
        return sort(iplCSVComparator);
    }

    public String getFoursWiseSortedData() throws CricketLeagueAnalyserException {
        Comparator<IplSheetDAO> iplCSVComparator =Comparator.comparing(sortBy->sortBy.fours);
        return sort(iplCSVComparator);
    }

    public String getStrikeRateWiseWithSixesAndFoursSortedData() throws CricketLeagueAnalyserException {
        Comparator<IplSheetDAO> iplCSVCompareByFoursSixesAndStrikeRate =
                Comparator.comparing(sortBy->sortBy.combinationOfFoursSixesAndStriteRate);
        return sort(iplCSVCompareByFoursSixesAndStrikeRate);
    }

    public String getSixesAndFoursWiseSortedData() throws CricketLeagueAnalyserException {
        Comparator<IplSheetDAO> iplCSVCompareByFoursAndSixes =
                Comparator.comparing(sortBy->sortBy.combinationOfFoursAndSixes);
        return sort(iplCSVCompareByFoursAndSixes);
    }

    public String getBestCombinationOfAverageAndStrikeRate() throws CricketLeagueAnalyserException {
        Comparator<IplSheetDAO> iplCSVCompareByStrikeRateAndAverage =
                Comparator.comparing(sortBy->sortBy.combinationOfStrikeRateAndAverage);
        return sort(iplCSVCompareByStrikeRateAndAverage);
    }

    public String getBestCombinationRunsAndAverage() throws CricketLeagueAnalyserException {
        Comparator<IplSheetDAO> iplCSVCompareByRunsAndAverage =
                Comparator.comparing(sortBy->sortBy.combinationOfRunsWithAverage);
        return sort(iplCSVCompareByRunsAndAverage);
    }

    public String getBowlingAverage() throws CricketLeagueAnalyserException {
        Comparator<IplSheetDAO> iplCSVCompareByBowlingAverage =
                Comparator.comparing(sortBy->sortBy.average);
        return sort(iplCSVCompareByBowlingAverage);
    }

    public String getEconomyWiseSortedData() throws CricketLeagueAnalyserException {
        Comparator<IplSheetDAO> iplCSVCompareByEconomy =Comparator.comparing(sortBy->sortBy.economy);
        return sort(iplCSVCompareByEconomy);
    }

    public String getBestOfStrikeRateWith4And5Wickets() throws CricketLeagueAnalyserException {
        Comparator<IplSheetDAO> iplCSVBestOfStrikeRateWith4And5Wickets=
                Comparator.comparing(sortBy->sortBy.combinationOfStrikeRateWith4And5Wickets);
        return sort(iplCSVBestOfStrikeRateWith4And5Wickets);
    }

    public String getBestOfBowlingStrikeRateWithAverage() throws CricketLeagueAnalyserException {
        Comparator<IplSheetDAO> iplCSVBestOfBolwingStrikeRateWithAverage=
                Comparator.comparing(sortBy->sortBy.combinationOfBowlingStrikeRateWithAverage);
        return sort(iplCSVBestOfBolwingStrikeRateWithAverage);
    }


    public String getMaxWicketsWithBestBowlingAverage() throws CricketLeagueAnalyserException {
        Comparator<IplSheetDAO> iplCSVBestOfBolwingStrikeRateWithAverage=
                Comparator.comparing(sortBy->sortBy.combinationOfMaxWicketsWithBowlingAverage);
        return sort(iplCSVBestOfBolwingStrikeRateWithAverage);
    }


    public String getBestBowlingAndBattingAverage() throws CricketLeagueAnalyserException {
        Comparator<IplSheetDAO> iplCSVBestOfBolwingStrikeRateWithAverage=
                Comparator.comparing(sortBy->(sortBy.average*sortBy.runs*sortBy.bowlingAverage+sortBy.wickets));
        return sort(iplCSVBestOfBolwingStrikeRateWithAverage);
    }


    public String getBestRunsAndWickets() throws CricketLeagueAnalyserException {
        Comparator<IplSheetDAO> iplCSVBestOfBolwingStrikeRateWithAverage=
                Comparator.comparing(sortBy->(sortBy.runs*sortBy.wickets));
        return sort(iplCSVBestOfBolwingStrikeRateWithAverage);
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
