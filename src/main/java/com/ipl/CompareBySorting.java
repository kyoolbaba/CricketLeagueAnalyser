package com.ipl;

import java.util.Comparator;
import java.util.EnumMap;

public class CompareBySorting {

static EnumMap<CricketLeagueAnalyser.CompareBy, Comparator<IplSheetDAO>> enumMap
        =new EnumMap(CricketLeagueAnalyser.CompareBy.class);


public  static Comparator<IplSheetDAO> getComparatorforSorting(CricketLeagueAnalyser.CompareBy compareOptions){
    enumMap.put(CricketLeagueAnalyser.CompareBy.COMPARE_BY_AVERAGE,
            Comparator.comparing(sortBy->sortBy.average));
    enumMap.put(CricketLeagueAnalyser.CompareBy.COMPARE_BY_STRIKERATE,
            Comparator.comparing(sortBy->sortBy.strikeRate));
    enumMap.put(CricketLeagueAnalyser.CompareBy.COMBINATION_OF_STRIKERATE_AND6AND4,
            Comparator.comparing(sortBy->sortBy.combinationOfFoursSixesAndStriteRate));
    enumMap.put(CricketLeagueAnalyser.CompareBy.COMBINAITON_OF_4AND6,
            Comparator.comparing(sortBy->sortBy.combinationOfFoursAndSixes));
    enumMap.put(CricketLeagueAnalyser.CompareBy.COMBINATION_OF_STRIKERATE_WITH_AVERAGE,
            Comparator.comparing(sortBy->sortBy.combinationOfStrikeRateAndAverage));
    enumMap.put(CricketLeagueAnalyser.CompareBy.COMBINATION_OF_RUNS_WITH_BEST_AVERAGES,
            Comparator.comparing(sortBy->sortBy.combinationOfRunsWithAverage));
    enumMap.put(CricketLeagueAnalyser.CompareBy.COMPARE_BY_BOWLINGAVERAGE,
            Comparator.comparing(sortBy->sortBy.bowlingAverage));
    enumMap.put(CricketLeagueAnalyser.CompareBy.COMPARE_BY_BOWLINGSTRIKERATE,
            Comparator.comparing(sortBy->sortBy.strikeRate));
    enumMap.put(CricketLeagueAnalyser.CompareBy.COMPARE_BY_BESTECONOMY,
            Comparator.comparing(sortBy->sortBy.economy));
    enumMap.put(CricketLeagueAnalyser.CompareBy.COMBINATION_OF_BESTSTRIKERAT_EWITH4AND5WICKETS,
            Comparator.comparing(sortBy->sortBy.combinationOfStrikeRateWith4And5Wickets));
    enumMap.put(CricketLeagueAnalyser.CompareBy. COMBINAITON_WITH_BOWLINGAVERAGEWITHMAX_WICKETS,
            Comparator.comparing(sortBy->sortBy.combinationOfMaxWicketsWithBowlingAverage));
    enumMap.put(CricketLeagueAnalyser.CompareBy.COMBINATION_OF_BOWLINGAVERAGE_WITH_STRIKERATE,
            Comparator.comparing(sortBy->sortBy.combinationOfBowlingStrikeRateWithAverage));
    enumMap.put(CricketLeagueAnalyser.CompareBy.BEST_BATTING_AND_BOWLING_AVERAGES,
            Comparator.comparing(sortBy->sortBy.bestBowlingAndBattingAverages));
    enumMap.put(CricketLeagueAnalyser.CompareBy.ALLROUNDERS,
            Comparator.comparing(sortBy->sortBy.bestWicketsAndRuns));
    return   enumMap.get(compareOptions);
}

}
