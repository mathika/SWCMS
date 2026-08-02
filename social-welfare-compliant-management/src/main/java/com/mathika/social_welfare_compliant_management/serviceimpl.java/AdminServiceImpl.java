@Service
public class AdminServiceImpl 
implements AdminService {


@Autowired
ComplaintRepository complaintRepository;


@Autowired
DepartmentRepository departmentRepository;



@Override
public Object getAllComplaints(){

    return complaintRepository.findAll();

}



@Override
public Object assignDepartment(
Long complaintId,
Long departmentId){


Complaint complaint =
complaintRepository
.findById(complaintId)
.get();



Department department =
departmentRepository
.findById(departmentId)
.get();



complaint.setDepartment(department);


complaint.setStatus("ASSIGNED");


return complaintRepository.save(complaint);


}



@Override
public Object getDashboard(){

long total =
complaintRepository.count();


return total;

}


}