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

public class IplWicketsSheetCSVAdapter {
    public <E> Map loadRunsSheetData(String csvFilePath, Class<E> csvClass) throws CricketLeagueAnalyserException {
        {
            Map<String, IplRunSheetDAO> runSheetMap = new HashMap<String, IplRunSheetDAO>();
            try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
                ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
                Iterator<E> csvIterator = icsvBuilder.getCSVFileIterator(reader, csvClass);
                Iterable<E> csvIterable = () -> csvIterator;
                StreamSupport.stream(csvIterable.spliterator(), false)
                        .map(Ipl2019WicketsSheetCSV.class::cast)
                        .forEach(iplRunsCSV -> runSheetMap.put(iplRunsCSV.player, new IplRunSheetDAO(iplRunsCSV)));
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
