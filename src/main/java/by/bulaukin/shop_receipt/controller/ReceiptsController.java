package by.bulaukin.shop_receipt.controller;

import by.bulaukin.shop_receipt.pars_data.data.RequestsParsingResult;
import by.bulaukin.shop_receipt.pars_data.data.ItemsFromRequest;
import by.bulaukin.shop_receipt.run_app.RunningApp;
import by.bulaukin.shop_receipt.view.ReceiptsView;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping()
public class ReceiptsController {
    private final RunningApp runningAppFromUrl;
    private final ModelAndView modelAndView;
    private final ReceiptsView receiptsView;

    @ModelAttribute("receipts")
    public ReceiptsView receiptsView() {
        return receiptsView;
    }

    @GetMapping("/")
    public String handleMain(Model model){
        model.addAttribute("requestsParsingResult", new RequestsParsingResult());
        return "index";
    }

    @PostMapping(value = "/addItems", params={"addRow"})
    public String addRow(final RequestsParsingResult requestsParam, Model model){
        requestsParam.getItemsList().add(new ItemsFromRequest());
        log.info("addRow");
        return "index";
    }

    @PostMapping(value="/addItems", params={"removeRow"})
    public String removeRow(final RequestsParsingResult requestsParam,
                            final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        requestsParam.getItemsList().remove(rowId.intValue());
        log.info("remove");
        return "index";
    }

    @PostMapping(value = "/addItems", params = {"save"})
    public String save(final RequestsParsingResult requestsParam,
                       Model model){
        runningAppFromUrl.run(requestsParam);
        model.addAttribute("receipts", modelAndView.getModel().get("receipt"));
        return "index";
    }
}
