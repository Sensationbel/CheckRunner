package by.bulaukin.shop_receipt.pars_data.getting_data;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@Log4j2
public class GettingDataFromFile implements GettingData {
    @Override
    public <T> String[] parsData(T request) throws IOException {

        String[] data = (String[]) request;

        byte[] content = Files.readAllBytes(Paths.get(data[0]));
        return new String(content).split("\s+");

    }
}
