package ge.economy.law.controller;

import ge.economy.law.misc.Response;
import ge.economy.law.request.AddCaseRequest;
import ge.economy.law.request.SearchCaseRequest;
import ge.economy.law.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * @author ucha
 */
@RequestMapping("/cases")
@Controller
public class CaseController {

    @Autowired
    private CaseService caseService;

    @ResponseBody
    @RequestMapping({"/get-cases"})
    public Response getInitiate(@RequestParam("start") int start, @RequestParam("limit") int limit, @RequestBody SearchCaseRequest srchCase) {
        return Response.withSuccess(caseService.getCases(start, limit, srchCase));
    }

    @ResponseBody
    @RequestMapping({"/get-status"})
    public Response getStatuses() {
        return Response.withSuccess(caseService.getStatus());
    }

    @ResponseBody
    @RequestMapping({"/get-instance-history"})
    public Response getInitiate(@RequestParam int id, @RequestParam String number) {
        return Response.withSuccess(caseService.getInstanceHistory(id, number));
    }

    @ResponseBody
    @RequestMapping({"/save-case"})
    public Response saveIssue(@RequestBody AddCaseRequest request, HttpServletRequest servletRequest) {
        request.setAddUserId((Integer) servletRequest.getSession().getAttribute("userId"));
        return Response.withSuccess(caseService.save(request));
    }

    @RequestMapping({"/delete-case"})
    @ResponseBody
    public Response deleteCourt(@RequestParam int id) {
        caseService.deleteCase(id);
        return Response.withSuccess(true);
    }

}
