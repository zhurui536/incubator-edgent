/*
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
*/
package quarks.tests.connectors.wsclient.javax.websocket;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class KeystorePath {
    
    public static String getStorePath(String storeLeaf) {
        String pathStr = System.getProperty("user.dir");
        // Under eclipse/junit: path to project in repo: <repo>/connectors
        // Under ant/junit: <repo>/connectors/<project>/unittests/testrunxxxxxxx
        // Get the path to the <repo>/connectors
        Path path = new File(pathStr).toPath();
        do {
            if (path.endsWith("connectors"))
                break;
            path = path.getParent();
        } while (path != null);
        path = path.resolve(Paths.get("wsclient-javax.websocket",
                            "src", "test", "keystores", storeLeaf));
        if (!path.toFile().exists())
            throw new IllegalArgumentException("File does not exist: "+path);
        return path.toString();
    }

}
