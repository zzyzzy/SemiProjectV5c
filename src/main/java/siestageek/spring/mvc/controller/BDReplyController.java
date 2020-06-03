package siestageek.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import siestageek.spring.mvc.service.BDReplyService;
import siestageek.spring.mvc.vo.ReplyVO;

@Controller
public class BDReplyController {

    private BDReplyService brsrv;

    @Autowired
    public BDReplyController(BDReplyService brsrv) {
        this.brsrv = brsrv;
    }

    // 댓글쓰기 완료
    @PostMapping(value = "/reply/bdrpywrite")
    public String bdrpywrite(ReplyVO rvo) {

        brsrv.makeReply(rvo);

        return "redirect:/board/view.do?bno=" + rvo.getBno();
    }

    // 대댓글쓰기 완료
    @PostMapping(value = "/reply/bdcmtwrite")
    public String bdcmtwrite(ReplyVO rvo) {

        brsrv.makeComment(rvo);

        return "redirect:/board/view.do?bno=" + rvo.getBno();
    }
}
