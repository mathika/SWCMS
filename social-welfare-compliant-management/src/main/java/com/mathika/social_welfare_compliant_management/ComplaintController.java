@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @PostMapping
    public String saveComplaint(

            @RequestParam String description,

            @RequestParam MultipartFile image,

            @RequestParam Double latitude,

            @RequestParam Double longitude

    ) {

        System.out.println(description);

        System.out.println(latitude);

        System.out.println(longitude);

        return "Complaint Received";

    }

}