package siestageek.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siestageek.spring.mvc.dao.GalleryDAO;
import siestageek.spring.mvc.vo.GalleryVO;

@Service("gsrv")
public class GalleryService {

    private GalleryDAO gdao;

    @Autowired
    public GalleryService(GalleryDAO gdao) {
        this.gdao = gdao;
    }

    // 새 갤러리 쓰기
    public void newGallery(GalleryVO gvo) {
        gdao.insertGallery(gvo);
    }

}
