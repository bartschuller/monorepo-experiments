#!/usr/bin/env groovy

// TODO use parallel https://stackoverflow.com/questions/40143500/how-to-make-pipeline-job-to-wait-for-all-triggered-parallel-jobs
// and have a stage for every layer of possible dependency
// so layer 1: foundational libs
// layer 2: libs that use layer 1 libs
// layer 3: all apps
//
// for each layer we test first whether to run at all, then determine what to build exactly.
// note that each layer needs to encode dependency info on previous layer's libs.
// then do it using "parallel"

pipeline {
    agent {
        node {
            label 'common-ws-agent'
            customWorkspace 'monorepo-experiments-master'
        }
    }

    stages {
        stage('init') {
            steps {
                script {
                    def scmVars = checkout scm
                    env.MY_GIT_PREVIOUS_SUCCESSFUL_COMMIT = scmVars.GIT_PREVIOUS_SUCCESSFUL_COMMIT
                }
            }
        }
        stage('monorepo-library') {
            when {
                expression {
                    matches = sh(returnStatus:true, script: "git diff --name-only $MY_GIT_PREVIOUS_SUCCESSFUL_COMMIT|egrep -q '^monorepo-library'")
                    return !matches
                }
            }
            steps {
                build 'monorepo-library'
            }
        }
        stage('play-a') {
            when {
                expression {
                    matches = sh(returnStatus: true, script: "git diff --name-only $MY_GIT_PREVIOUS_SUCCESSFUL_COMMIT|egrep -q '^play-a'")
                    return !matches
                }
            }
            steps {
                build 'play-a'
            }
        }
        stage('play-b') {
            when {
                expression {
                    matches = sh(returnStatus: true, script: "git diff --name-only $MY_GIT_PREVIOUS_SUCCESSFUL_COMMIT|egrep -q '^play-b'")
                    return !matches
                }
            }
            steps {
                build 'play-b'
            }
        }
    }
}
