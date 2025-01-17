SUMMARY = "Packages installable via OPKG"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r1"

RDEPENDS_packagegroup-opkg-feed = "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd-analyze systemd-bootchart', '', d)} \
    atop \
    bash \
    chrony \
    chronyc \
    cuitest \
    curl \
    emc-tools \
    gdb \
    gdbserver \
    git \
    htop \
    i2c-tools \
    iftop \
    iotop \
    iperf3 \
    iputils \
    lsof \
    mc \
    minicom \
    mtd-utils \
    net-tools \
    netcat \
    network-management \
    ntpdate \
    picocom \
    prelink \
    pstree \
    pv \
    python3-pip \
    rsync \
    screen \
    sed \
    socat \
    srecord \
    strace \
    stresstest-download \
    swdtool \
    tar \
    tcpdump \
    traceroute \
    tshark \
    vim \
    wget \
    xz \
    zsh \
    "
