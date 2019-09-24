/**************************************************************
***** Description :: This Package is used for Maven Build *****
***** Author      :: Prmaod Vishwakarma                   *****
***** Date        :: 23/06/2019                           *****
***** Revision    :: 1.0                                  *****
***************************************************************/

package pkjee.devops.build

/********************************************
** Function to Maven Build Process      *****
*********************************************/
def MavenBuild(String MAVEN_HOME, String MAVEN_GOAL)
{
  try {
    wrap([$class: 'AnsiColorBuildWrapper']) {
      println "\u001B[32mINFO => Building Maven modules, please wait..."
      sh "$MAVEN_HOME/bin/mvn $MAVEN_GOAL"
    }
  }
   catch (Exception caughtException) {
      wrap([$class: 'AnsiColorBuildWrapper']) {
         println "\u001B[41mERROR => failed to install Maven modules..."
         currentBuild.result = 'FAILED'
         throw caughtException
    }
  }
}
