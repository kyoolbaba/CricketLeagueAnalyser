package com.ipl;

import java.util.Map;

public class IplAdapterFactory {
    public static Map <String, IplSheetDAO> getCensusData(String csvFilePath, CricketLeagueAnalyser.IplSheet sheet) throws CricketLeagueAnalyserException {
        if(sheet.equals(CricketLeagueAnalyser.IplSheet.WICKETSHEET))
            return new IplWicketsSheetCSVAdapter().loadRunsSheetData(csvFilePath,Ipl2019WicketsSheetCSV.class);
        return new IplRunsSheetCSVAdapter().loadRunsSheetData(csvFilePath,Ipl2019RunsSheetCSV.class);
    }
}
