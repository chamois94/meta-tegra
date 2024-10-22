DESCRIPTION = "NVIDIA CUDA utils"
L4T_DEB_COPYRIGHT_MD5 = "3eee7940f3706b5eb2411a575788e804"
DEPENDS = "tegra-libraries-cuda"

L4T_DEB_TRANSLATED_BPN = "nvidia-l4t-cuda-utils"

require tegra-debian-libraries-common.inc

SRC_SOC_DEBS += "${@l4t_deb_pkgname(d, 'init')};subdir=${BP};name=init"

MAINSUM = "2e52540c7d9f488fcb28da975800de0f6c17dc0187c2242657c8e68b2be7a10a"
INITSUM = "9f6af623a7d10bb10ca9c8d28efc8204554cfe1eca5507c5bc9d1f033f138ca8"
SRC_URI[init.sha256sum] = "${INITSUM}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/usr/bin/nvidia-cuda-mps-* ${D}${bindir}/
}

PACKAGES = "${PN}"
FILES:${PN} = "${bindir}"

PACKAGE_ARCH = "${SOC_FAMILY_PKGARCH}"
