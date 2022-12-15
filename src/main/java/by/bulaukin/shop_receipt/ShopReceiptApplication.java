package by.bulaukin.shop_receipt;

import by.bulaukin.shop_receipt.parsData.DataTypes;
import by.bulaukin.shop_receipt.parsData.GettingData;
import by.bulaukin.shop_receipt.parsData.GettingDataFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
@RequiredArgsConstructor
public class ShopReceiptApplication implements CommandLineRunner {
	private final GettingDataFactory factory;
	public static void main(String[] args) {
		log.info("Starting the Application");
		String[] args1 = new String[] {"3-1", "2-5", "5-1", "card-1234"};
		SpringApplication.run(ShopReceiptApplication.class, args1);
		log.info("Finished the Application");
	}

	@Override
	public void run(String... args1) throws Exception {
		log.info("Executing : command line runner");

		GettingData data = factory.getClass(DataTypes.CONSOLE);
		data.parsData(args1);


	}
}
