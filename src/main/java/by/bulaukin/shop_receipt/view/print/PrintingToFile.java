package by.bulaukin.shop_receipt.view.print;

import by.bulaukin.shop_receipt.view.convert.ConvertingViews;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Service(value = "printingToFile")
@RequiredArgsConstructor
@Log4j2
public class PrintingToFile implements PrintingViews{
    private final ConvertingViews receiptsViewToString;

    @Value("${download.path}")
    private String downloadPath;
    private Charset utf8 = StandardCharsets.UTF_8;

    @Override
    public void printViews() {
        String file = receiptsViewToString.convertsViews();
        log.debug("Download path: {}", downloadPath);
        try {
            Files.write(Paths.get(downloadPath), file.getBytes(utf8), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
