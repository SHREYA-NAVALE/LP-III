// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract StudentDB {

    struct Student {
        string name;
        uint256 rollno;
        string class;
    }

    Student[] private students;

    // Add student
    function addStudent(string memory name, uint256 rollno, string memory class) public {
        students.push(Student(name, rollno, class));
    }

    // ✅ Get student by roll number (easy lookup)
    function getStudentByRoll(uint256 rollno) public view returns(string memory, string memory) {
        for(uint256 i = 0; i < students.length; i++) {
            if(students[i].rollno == rollno) {
                return (students[i].name, students[i].class);
            }
        }
        revert("Student with this roll number not found");
    }

    // Total students
    function getTotalStudents() public view returns(uint256) {
        return students.length;
    }

    fallback() external payable {}
    receive() external payable {}
}
