require qt5.inc 
require qt5-git.inc
 
LICENSE = "GFDL-1.3 & BSD & ( GPL-3.0 & The-Qt-Company-GPL-Exception-1.0 | The-Qt-Company-Commercial ) & ( GPL-2.0+ | LGPL-3.0 | The-Qt-Company-Commercial )"
LIC_FILES_CHKSUM = " \ 
    file://LICENSE.FDL;md5=6d9f2a9af4c8b8c3c769f6cc1b6aaf7e \
    file://LICENSE.GPL2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \ 
    file://LICENSE.GPL3;md5=d32239bcb673463ab874e80d47fae504 \
    file://LICENSE.GPL3-EXCEPT;md5=763d8c535a234d9a3fb682c7ecb6c073 \ 
    file://LICENSE.GPLv2;md5=c96076271561b0e3785dad260634eaa8 \
    file://LICENSE.GPLv3;md5=88e2b9117e6be406b5ed6ee4ca99a705 \ 
    file://LICENSE.LGPL3;md5=e6a600fd5e1d9cbde2d983680233ad02 \
    file://LICENSE.LGPLv21;md5=4bfd28363f541b10d9f024181b8df516 \ 
    file://LICENSE.LGPLv3;md5=e0459b45c5c4840b353141a8bbed91f0 \
    file://LGPL_EXCEPTION.txt;md5=9625233da42f9e0ce9d63651a9d97654 \ 
"
 
DEPENDS += "qtbase"
ALLOW_EMPTY_${PN} = "1" 

SRC_URI += "file://0001-qtimageformats.pro-Make-the-dependencies-determinist.patch" 

PACKAGECONFIG ?= "libtiff" 
# Currently we don't have recipe for libmng, but lock it anyway so qtimageformats stay deterministic even when libmng is introduced
PACKAGECONFIG[jasper] = ",,jasper" 
PACKAGECONFIG[libmng] = ",,libmng"
PACKAGECONFIG[libtiff] = ",,tiff" 
PACKAGECONFIG[libwebp] = ",,libwebp"
 
EXTRA_QMAKEVARS_PRE += "${@base_contains('PACKAGECONFIG', 'libmng', 'CONFIG+=OE_LIBMNG_ENABLED', '', d)}"
EXTRA_QMAKEVARS_PRE += "${@base_contains('PACKAGECONFIG', 'jasper', 'CONFIG+=OE_JASPER_ENABLED', '', d)}" 
EXTRA_QMAKEVARS_PRE += "${@base_contains('PACKAGECONFIG', 'libtiff', 'CONFIG+=OE_LIBTIFF_ENABLED', '', d)}"
EXTRA_QMAKEVARS_PRE += "${@base_contains('PACKAGECONFIG', 'libwebp', 'CONFIG+=OE_LIBWEBP_ENABLED', '', d)}" 

SRCREV = "11300c62aa021ef07f3e4de8bd875bfcbcbe2f7e" 
