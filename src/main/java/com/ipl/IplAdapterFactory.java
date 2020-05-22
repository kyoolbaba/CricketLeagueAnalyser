package com.ipl;

import java.util.Map;

public class IplAdapterFactory {
    public static Map <String, IplSheetDAO> getIPLData(CricketLeagueAnalyser.IplSheet sheet, String... csvFilePath)
                                                                                throws CricketLeagueAnalyserException {
        return (sheet.equals(CricketLeagueAnalyser.IplSheet.WICKETSHEET))?
                new IplBolwersSheetCSVAdapter().loadIplSheetData( Ipl2019BowlersSheetCSV.class,csvFilePath):
                new IplBatsmenSheetCSVAdapter().loadIplSheetData( Ipl2019BatsmenSheetCSV.class,csvFilePath);
    }
}
