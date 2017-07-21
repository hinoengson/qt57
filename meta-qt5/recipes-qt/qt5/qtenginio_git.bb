require qt5.inc 
require qt5-git.inc
 
LICENSE = "GFDL-1.3 & BSD & ( GPL-3.0 & The-Qt-Company-GPL-Exception-1.0 | The-Qt-Company-Commercial ) & ( GPL-2.0+ | LGPL-3.0 | The-Qt-Company-Commercial )"
LIC_FILES_CHKSUM = " \ 
    file://LICENSE.LGPLv21;md5=58a180e1cf84c756c29f782b3a485c29 \
    file://LICENSE.LGPLv3;md5=b8c75190712063cde04e1f41b6fdad98 \ 
    file://LICENSE.GPLv3;md5=40f9bf30e783ddc201497165dfb32afb \
    file://LGPL_EXCEPTION.txt;md5=9625233da42f9e0ce9d63651a9d97654 \ 
    file://LICENSE.FDL;md5=f70ee9a6c44ae8917586fea34dff0ab5 \
    " 

DEPENDS += "qtbase qtdeclarative qtxmlpatterns" 

QT_MODULE_BRANCH = "5.7" 
SRCREV = "15090ec53621211616c4136ab37e0332c3ae709a"
 
do_install_append() {
    if ls ${D}${libdir}/pkgconfig/Enginio.pc >/dev/null 2>/dev/null; then 
        sed -i "s@-L${STAGING_LIBDIR}@-L\${libdir}@g" ${D}${libdir}/pkgconfig/Enginio.pc
    fi 
}
