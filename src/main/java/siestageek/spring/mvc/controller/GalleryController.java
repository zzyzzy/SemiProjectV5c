package siestageek.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import siestageek.spring.mvc.service.GalleryService;
import siestageek.spring.mvc.vo.GalleryVO;

@Controller
public class GalleryController {

    private GalleryService gsrv;

    @Autowired
    public GalleryController(GalleryService gsrv) {
        this.gsrv = gsrv;
    }

    // 목록보기
    @RequestMapping(value = "gallery/list")
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("layout/layout"); // 뷰이름 지정

        mv.addObject("action", "../gallery/list.jsp");
        // 뷰로 넘길 데이터를 modelandview 객체에 담음

        return mv;
    }

    // 새글쓰기
    @RequestMapping(value = "gallery/write")
    public ModelAndView write() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("layout/layout"); // 뷰이름 지정

        mv.addObject("action", "../gallery/write.jsp");
        // 뷰로 넘길 데이터를 modelandview 객체에 담음

        return mv;
    }

    // 새글쓰기
    @PostMapping(value = "gallery/write")
    public String writeok(GalleryVO gvo) {

        gsrv.newGallery(gvo);

        return "redirect:/gallery/list";
    }

    @RequestMapping(value = "gallery/view")
    public ModelAndView view() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("layout/layout"); // 뷰이름 지정

        mv.addObject("action", "../gallery/view.jsp");
        // 뷰로 넘길 데이터를 modelandview 객체에 담음

        return mv;
    }


}
