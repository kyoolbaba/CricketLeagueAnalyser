package com.ipl;

import com.IndianCensus.CSVBuilderException;
import com.IndianCensus.CSVBuilderFactory;
import com.IndianCensus.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class IplBatsmenSheetCSVAdapter extends CricketLeagueAdapter{


    @Override
    public <E> Map loadIplSheetData( Class<E> csvClass,String ... csvFilePath) throws CricketLeagueAnalyserException {
        Map<String,IplSheetDAO> sheetMap= null;
        if(csvFilePath.length>1){
            sheetMap=super.loadIplCricketSheetData(csvFilePath[0], Ipl2019BatsmenSheetCSV.class);
            return this.loadBowlersSheetData(csvFilePath[1],sheetMap);
        }else{
            return super.loadIplCricketSheetData(csvFilePath[0], Ipl2019BatsmenSheetCSV.class);
        }

    }


    public <E> Map loadBowlersSheetData(String csvFilePath, Map<String,IplSheetDAO> mapSheet) throws CricketLeagueAnalyserException {
        {
            Map<String, IplSheetDAO> runSheetMap = new HashMap<String, IplSheetDAO>();
            try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
                ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
                Iterator<Ipl2019BowlersSheetCSV> csvIterator = icsvBuilder.getCSVFileIterator(reader, Ipl2019BowlersSheetCSV.class);
                Iterable<Ipl2019BowlersSheetCSV> csvIterable = () -> csvIterator;
                StreamSupport.stream(csvIterable.spliterator(),false)
                        .filter(iplBowlingSheet->mapSheet.get(iplBowlingSheet.player)!=null)
                        .forEach(iplBowlingSheet->mapSheet.get(iplBowlingSheet.player).average=iplBowlingSheet.bowlingAverage);
                StreamSupport.stream(csvIterable.spliterator(),false)
                        .filter(iplBowlingSheet->mapSheet.get(iplBowlingSheet.player)!=null)
                        .forEach(iplBowlingSheet->mapSheet.get(iplBowlingSheet.player).wickets=iplBowlingSheet.wickets);
                return runSheetMap;
            } catch (IOException e) {
                throw new CricketLeagueAnalyserException("problem with CSV file",
                        CricketLeagueAnalyserException.ExceptionType.FILE_NOT_PRESENT);

            } catch (CSVBuilderException e) {
                throw new CricketLeagueAnalyserException(e.getMessage(),
                        CricketLeagueAnalyserException.ExceptionType.NOT_ABLE_TO_PARSE);
            } catch (RuntimeException e) {
                throw new CricketLeagueAnalyserException(e.getMessage(),
                        CricketLeagueAnalyserException.ExceptionType.DATA_NOT_APPROPRIATE);
            }
        }
    }

}
