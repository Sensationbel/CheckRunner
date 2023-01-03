package by.bulaukin.shop_receipt;

import by.bulaukin.shop_receipt.run_app.factory.ParsingAndViewFactory;
import by.bulaukin.shop_receipt.run_app.factory.RunAppFromConsole;
import by.bulaukin.shop_receipt.run_app.factory.RunAppFromFile;
import by.bulaukin.shop_receipt.run_app.run.RunningApp;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
@RequiredArgsConstructor
public class ShopReceiptApplication implements CommandLineRunner {

	private ParsingAndViewFactory parsingAndViewFactory;
	@Qualifier(value = "runAppFromConsole")
	private final RunAppFromConsole runAppFromConsole;
	@Qualifier(value = "runAppFromFile")
	private final RunAppFromFile runAppFromFile;
	private final RunningApp runningAppFromConsole;

	public static void main(String[] args) {
		log.info("Starting the Application");
		String[] args1 = new String[] {"11-6", "13-6", "5-1", "1-3", "20-2", "card-2569 "};
		String[] args2 = new String[] {"C:\\Users\\Sensationbel\\Desktop\\data.txt"};
			SpringApplication.run(ShopReceiptApplication.class, args2);
		log.info("Finished the Application");
	}

	@Override
	public void run(String... args) throws Exception {
		if(args.length >= 1){
			configureApp(args);
			runningAppFromConsole.setParsingAndViewFactory(parsingAndViewFactory);
			runningAppFromConsole.run(args);
		}
	}

	private  void configureApp(String[] args){
		if(args.length == 1) {
			parsingAndViewFactory = runAppFromFile;
		} else if(args.length > 1){
			parsingAndViewFactory = runAppFromConsole;
		}
	}
}
