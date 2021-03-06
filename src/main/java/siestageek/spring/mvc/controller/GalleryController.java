package siestageek.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
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

        mv.addObject("glist", gsrv.showGallery());

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
    // 여러 개의 이미지 파일을 업로드하는 경우
    // 이미지 폼 이름은 모두 동일하게 설정함
    // 즉, MultipartFile img1, MultipartFile img2,
    // MultipartFile img3 식으로 사용하는 것보다는
    // MultipartFile[] img 식으로 사용하는 것이 더 편하기 때문임
    @PostMapping(value = "gallery/write")
    public String writeok(GalleryVO gvo, MultipartFile[] img) {

        gsrv.newGallery(gvo, img);

        return "redirect:/gallery/list";
    }

    @RequestMapping(value = "gallery/view")
    public ModelAndView view(String gno) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("layout/layout"); // 뷰이름 지정

        mv.addObject("action", "../gallery/view.jsp");
        // 뷰로 넘길 데이터를 modelandview 객체에 담음

        mv.addObject("g", gsrv.showOneGallery(gno));

        return mv;
    }


}
