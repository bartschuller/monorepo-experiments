#!/usr/bin/env groovy

pipeline {
    agent any

    stages {
        stage('init') {
            steps {
                script {
                    def sbtHome = tool 'sbt'
                    env.sbt= "${sbtHome}/bin/sbt -no-colors -batch"
                }
            }
        }
        stage('Build') {
            steps {
                echo 'Building play-a'
                sh "cd play-a; $sbt compile"
                echo 'Building play-b'
                sh "cd play-b; $sbt compile"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing play-a'
                sh "cd play-a; $sbt test"
                echo 'Testing play-b'
                sh "cd play-b; $sbt test"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}