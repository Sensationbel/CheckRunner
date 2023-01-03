package by.bulaukin.shop_receipt.run_app.run;

import by.bulaukin.shop_receipt.run_app.factory.ParsingAndViewFactory;

public interface RunningApp {
    <T>void run(T requestsParam);
    void setParsingAndViewFactory(ParsingAndViewFactory factory);
}
