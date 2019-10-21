FILESEXTRAPATHS_prepend := "${THISDIR}/files/${MACHINE_ARCH}:"

PR_append = ".0"

SRC_URI += "file://fw_env.config"

do_install_append() {
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
}
