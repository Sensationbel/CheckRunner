package by.bulaukin.shop_receipt.run_app;

import by.bulaukin.shop_receipt.entity_to_dto.ResultEntityToDto;
import by.bulaukin.shop_receipt.entity_to_dto.ResultEntityToDtoService;
import by.bulaukin.shop_receipt.pars_data.DataFromRequest;
import by.bulaukin.shop_receipt.pars_data.DataFromRequestServices;
import by.bulaukin.shop_receipt.pars_data.DataTypes;
import by.bulaukin.shop_receipt.pars_data.getting_data.GettingData;
import by.bulaukin.shop_receipt.pars_data.getting_data.GettingDataFactory;
import by.bulaukin.shop_receipt.view.ReceiptsViewServices;
import by.bulaukin.shop_receipt.view.print.PrintingViews;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class RunningAppFromFile implements RunningApp {

    private final DataFromRequestServices dataFromRequestServices;
    private final ResultEntityToDtoService resultEntityToDtoService;
    private final ReceiptsViewServices viewServices;
    private final GettingDataFactory gettingDataFactory;
    private final DataFromConsole dataFromConsole;
    private final PrintingViews printingToFile;

    public void run() {

        try {
            GettingData dataFromFiles = gettingDataFactory.getClass(DataTypes.FILE);
            String[] data = dataFromFiles.parsData(dataFromConsole.getArgs());
            DataFromRequest dataFromRequest = dataFromRequestServices.parsData(data);
            ResultEntityToDto result = resultEntityToDtoService.getResult(dataFromRequest);
            viewServices.createsView(result);
            printingToFile.printViews();
        } catch (Exception e) {
            log.error("Path {} does not exist", dataFromConsole.getArgs()[0]);
        }

    }
}
