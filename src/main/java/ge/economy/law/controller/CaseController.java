package ge.economy.law.controller;

import ge.economy.law.misc.Response;
import ge.economy.law.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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
    public Response getInitiate(@RequestParam("start") int start, @RequestParam("limit") int limit) {
        return Response.withSuccess(caseService.getCases(start, limit));
    }

    @ResponseBody
    @RequestMapping({"/get-instance-history"})
    public Response getInitiate(@RequestParam int id) {
        return Response.withSuccess(caseService.getInstanceHistory(id));
    }

//    @ResponseBody
//    @RequestMapping({"/save-case"})
//    public Response saveIssue(@RequestBody AddInitiateRequest request, HttpServletRequest servletRequest) {
//        User u = (User) servletRequest.getSession().getAttribute(AuthInterceptor.CURRENT_USER);
//        if (u != null) {
//            UserDTO dto = (UserDTO) u.getUserData();
//            request.setUserId(dto.getId());
//        }
//        return Response.withData(initiateService.saveIssue(request));
//    }

    @RequestMapping({"/delete-case"})
    @ResponseBody
    public Response deleteCourt(@RequestParam int id) {
        caseService.deleteCase(id);
        return Response.withSuccess(true);
    }

}
