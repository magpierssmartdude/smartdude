/*
 * package com.smartdude.controller;
 * 
 * import java.security.Principal; import java.util.ArrayList; import
 * java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.ResponseBody; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.smartdude.entity.Address; import com.smartdude.entity.Person;
 * import com.smartdude.entity.User; import
 * com.smartdude.repository.AddressRepo; import
 * com.smartdude.repository.PersonRepo; import
 * com.smartdude.repository.UserRepository;
 * 
 * @RestController public class VendorController {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * @Autowired private PersonRepo personRepo;
 * 
 * @Autowired private AddressRepo addressRepo;
 * 
 * @Autowired private PasswordEncoder passwordEncoder;
 * 
 * @GetMapping("/welcome") public String welcomeMsg() { return
 * "Welcome to smart dude"; }
 * 
 * @RequestMapping(value = "/username", method = RequestMethod.GET)
 * 
 * @ResponseBody public String currentUserName(Principal principal) { return
 * principal.getName(); }
 * 
 * @PostMapping("/saveUser") public User saveUser(@RequestBody User user) {
 * System.out.println("Working ");
 * 
 * String password = passwordEncoder.encode(user.getPassword());
 * 
 * user.setPassword(password); User userf = userRepository.save(user); return
 * userf;
 * 
 * }
 * 
 * @GetMapping("/vendor") public String getVendor() { return "vendor details"; }
 * 
 * @GetMapping("/qm") public String getQM() { return "qm details"; }
 * 
 * 
 * @GetMapping("/noaccess") public String getnoAccess() { return
 * "access ledhu baabu"; }
 * 
 * 
 * @GetMapping("/admin") public String getAdmin() { return "admin details"; }
 * 
 * 
 * 
 * @GetMapping("/savePerson") public String savePerson() {
 * 
 * 
 * Person personHektor = new Person(); personHektor.setPersonId(9l);
 * personHektor.setName("RAM");
 * 
 * Address address = new Address(10,"HOSUR","England NW1","London",12345l);
 * List<Address> addresses = new ArrayList(); addresses.add(address);
 * personHektor.setAddresses(addresses);
 * 
 * addressRepo.save(address); personRepo.save(personHektor);
 * 
 * List<Person> personList = personRepo.findAll();
 * System.out.println("Person List : "); for (Person person : personList) {
 * System.out.println(person); }
 * 
 * System.out.println("Person with Id 1 is "+personRepo.searchByName("RAGHU"));
 * return "success";
 * 
 * }
 * 
 * 
 * }
 * 
 */