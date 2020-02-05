SUMMARY = "Extract device and environment specific data from U-Boot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd allarch

PV = "2019-10-27"
PR = "r2"

SRC_URI += " \
    file://ca-dev.crt \
    file://ca-prod.crt \
    file://ca-qa.crt \
    file://keep.d/${BPN} \
    file://${BPN}.sh \
    file://${BPN}.service \
"

FILES_${PN} += " \
    ${sysconfdir}/ssl/certs \
    ${sysconfdir}/ssl/private \
    ${base_libdir}/upgrade/keep.d \
    ${systemd_unitdir}/system \
"

do_install_append() {
    install -d ${D}${sysconfdir}/ssl/private

    install -d ${D}${sysconfdir}/ssl/certs
    install -m 644 ${WORKDIR}/ca-dev.crt ${D}${sysconfdir}/ssl/certs
    install -m 644 ${WORKDIR}/ca-prod.crt ${D}${sysconfdir}/ssl/certs
    install -m 644 ${WORKDIR}/ca-qa.crt ${D}${sysconfdir}/ssl/certs

    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/${PN}.sh ${D}${bindir}/${PN}

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/${PN}.service ${D}${systemd_unitdir}/system

    # Development: Keep certificates from being overwritten on update
    install -d ${D}${base_libdir}/upgrade/keep.d
    install -m 0644 ${WORKDIR}/keep.d/${PN} ${D}${base_libdir}/upgrade/keep.d
}

SYSTEMD_SERVICE_${PN} = "${PN}.service"
