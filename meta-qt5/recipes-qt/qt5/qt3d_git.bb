require qt5.inc 
require qt5-git.inc
 
LICENSE = "LGPL-3.0 | GPL-2.0"
LIC_FILES_CHKSUM = " \ 
    file://LICENSE.GPL;md5=c96076271561b0e3785dad260634eaa8 \
    file://LICENSE.GPL2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \ 
    file://LICENSE.GPL3;md5=d32239bcb673463ab874e80d47fae504 \
    file://LICENSE.GPL3-EXCEPT;md5=763d8c535a234d9a3fb682c7ecb6c073 \ 
    file://LICENSE.GPLv3;md5=88e2b9117e6be406b5ed6ee4ca99a705 \
    file://LICENSE.LGPL3;md5=e6a600fd5e1d9cbde2d983680233ad02 \ 
    file://LICENSE.LGPLv3;md5=8211fde12cc8a4e2477602f5953f5b71 \
    " 

DEPENDS += "qtbase" 
DEPENDS_class-target += "qtdeclarative qt3d-native"
 
SRC_URI += " \
    file://0001-Allow-a-tools-only-build.patch \ 
"
 
PACKAGECONFIG ??= ""
PACKAGECONFIG_class-native ??= "tools-only" 
PACKAGECONFIG_class-nativesdk ??= "tools-only"
PACKAGECONFIG[tools-only] = "CONFIG+=tools-only" 

EXTRA_QMAKEVARS_PRE += "${PACKAGECONFIG_CONFARGS}" 

FILES_${PN}-qmlplugins += " \ 
    ${OE_QMAKE_PATH_QML}/*/*/*.bez \
    ${OE_QMAKE_PATH_QML}/*/*/*.obj \ 
"
 
SRCREV = "0eac16fbda846c951f9b3887199e72b66f5aacd7"
 
BBCLASSEXTEND += "native nativesdk"
