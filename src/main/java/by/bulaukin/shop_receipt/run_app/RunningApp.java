package by.bulaukin.shop_receipt.run_app;

import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;

public interface RunningApp {
    <T>void run(T dataFromRequest);
}
