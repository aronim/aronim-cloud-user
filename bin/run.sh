#!/usr/bin/env bash

BASEDIR=$(dirname $0)
. ${BASEDIR}/../../scripts/build-run.sh

run ${BASEDIR} com.aronim.cloud.user.UserApplication