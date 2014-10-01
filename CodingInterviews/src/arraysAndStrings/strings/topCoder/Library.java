package arraysAndStrings.strings.topCoder;

import java.util.HashSet;
import java.util.Set;

/*
 * Mr. Agent has entered a government library where secret documents are stored.
 * Documents are stored in different rooms, and each document has a list of user
 * groups that can access it. In order to access a document, a person must have
 * access to the room in which the document is stored and also be a member of at
 * least one user group with access to the document. Your task is to determine
 * the number of documents Mr. Agent can access.
 * 
 * You are given a String[] userGroups, each element of which is the name of a
 * user group in which Mr. Agent is a member. You are also given a String[]
 * roomRights, each element of which is the name of a room to which Mr. Agent
 * has access. The documents are given in the String[] records. Each element of
 * records is formatted "document_name room user_group" (quotes for clarity),
 * where document_name is the name of a document, room is the name of the room
 * where the document is located, and user_group is the name of a user group
 * that has access to the document. If multiple user groups have access to a
 * document, there will be an entry in records for each group. All documents
 * have distinct names, all rooms have distinct names, and all user groups have
 * distinct names. Return the number of documents Mr. Agent can access.
 * 
 * 
 * records =
 * {"diary computers editor","fairytale gardening editor","comix cars author"
 * ,"comix cars librarian"} userGroups = {"employee","editor","author"}
 * roomRights = {"history","cars","computers"} Returns: 2
 */

public class Library {
    public static int documentAccess(String[] records, String[] userGroups,
            String[] roomRights) {
        Set<String> docs = new HashSet<String>();
        Set<String> groups = new HashSet<String>();
        Set<String> rooms = new HashSet<String>();

        for (String g : userGroups) {
            groups.add(g);
        }
        for (String r : roomRights) {
            rooms.add(r);
        }

        String[] parts;
        for (String r : records) {
            parts = r.split(" ");
            if (rooms.contains(parts[1]) && groups.contains(parts[2])) {
                docs.add(parts[0]);
            }
        }
        return docs.size();
    }

    public static void main(String[] args) {
        String[] records = { "diary computers editor",
                "fairytale gardening editor", "comix cars author",
                "comix cars librarian" };
        String[] groups = { "employee", "editor", "author" };
        String[] rooms = { "history", "cars", "computers" };
        System.out.println("0. " + documentAccess(records, groups, rooms));
        String[] groups2 = { "employee", "editor", "author", "librarian" };
        System.out.println("1. " + documentAccess(records, groups2, rooms));
        String[] rooms2 = {};
        System.out.println("2. " + documentAccess(records, groups2, rooms2));
        String[] records2 = { "a b c", "a b d", "b b c", "b b d", "e c d",
                "e c b", "e c c", "t d e" };
        String[] groups3 = { "c", "d", "x" };
        String[] rooms3 = { "a", "b", "c" };
        System.out.println("3. " + documentAccess(records2, groups3, rooms3));

    }
}
