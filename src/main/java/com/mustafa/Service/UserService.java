package com.mustafa.Service;

import com.mustafa.dto.request.LoginRequestDto;
import com.mustafa.dto.request.RegisterRequestDto;
import com.mustafa.dto.response.LoginResponceDto;
import com.mustafa.dto.response.RegisterResponceDto;
import com.mustafa.entity.User;
import com.mustafa.mapper.UserMapper;
import com.mustafa.repository.UserRepository;
import com.mustafa.utility.ICrudService;
import com.mustafa.utility.enums.EStatus;
import com.mustafa.utility.enums.EUserType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements ICrudService<User,Long> {
    private final UserRepository userRepository;

    public User register(String name, String surname, String email,String password ,String rePassword){
            User user = User.builder()
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .password(password)
                    .rePassword(rePassword)
                    .build();
            if(!password.equals(rePassword) || password.isBlank()) {
                throw new RuntimeException("Şifreler aynı değildir");
            }else{
                return userRepository.save(user);
            }
            /*
            Exception -> Checked -> Compile error. Derleme hatası
            RuntimeExeption -> Unchecked -> Runtime error. Çalışma zamanı hatası -> program çalışken gerçekleşir
             */
    }

    public User login(String email, String password){
        Optional<User> user =userRepository.findOptionalByEmailAndPassword(email,password);
        if(user.isPresent()){
            throw new RuntimeException("Böyle bir kullanıcı bulunamadı..");
        }
        return user.get();
    }


    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public Iterable<User> saveAll(Iterable<User> t) {
        return null;
    }

    @Override
    public User deleteById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            user.get().setStatus(EStatus.INACTIVE);
            return  userRepository.save(user.get());
        }else {
            throw new NullPointerException("Böyle bi kullanıcı bulunamadı");
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user;
        }else{
            throw new NullPointerException("Böyle bir kullanıcı yok");
        }

    }

    @Override
    public boolean existById(Long aLong) {
        return false;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        if(userList.isEmpty()){
            throw new NullPointerException("Liste boş");
        }
        return userList;
    }

    @Override
    public List<User> findByColumnAndValue(String columnName, Object value) {
        return null;
    }

    @Override
    public List<User> findAllEntity(User user) {
        return null;
    }

    public Optional<User> findOptionalByEmailAndPassword(String email, String password) {
        return userRepository.findOptionalByEmailAndPassword(email,password);
    }

    public RegisterResponceDto registerDto(RegisterRequestDto dto) {
        User user = User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .rePassword(dto.getRePassword())
                .build();
        if(!user.getPassword().equals(user.getRePassword()) || user.getPassword().isBlank()) {
            throw new RuntimeException("Şifreler aynı değildir");
        }
        userRepository.save(user);
        return RegisterResponceDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .status(user.getStatus())
                .build();

    }
    public Optional<User> loginDto1(LoginRequestDto dto) {
        Optional<User> user =userRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if(user.isEmpty()){
            throw new RuntimeException("Email veya şifre hatalıdır..");
        }
        return user;
    }
    public LoginResponceDto loginDto(LoginRequestDto dto) {
        User user = User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
        if(!user.getPassword().equals(dto.getPassword())){
            throw new RuntimeException("Böyle bir kullanıcı bulunamadı..");
        }
        return LoginResponceDto.builder()
                .email(user.getEmail())
                .build();
    }


    public LoginResponceDto loginMapper(LoginRequestDto dto) {
        Optional<User> user =userRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if(user.isEmpty()){
            throw new RuntimeException("Email veya şifre hatalıdır..");
        }
        return UserMapper.INSTANCE.fromUserToLoginResponceDto(user.get());
    }

    public RegisterResponceDto registerMapper(RegisterRequestDto dto) {
        User user = UserMapper.INSTANCE.fromRegisterRequestDtoToUser(dto);
        if(!user.getPassword().equals(user.getRePassword()) || user.getPassword().isBlank()) {
            throw new RuntimeException("Şifreler aynı değildir");
        }
        userRepository.save(user);
        return UserMapper.INSTANCE.fromUserToRegisterResponceDto(user);
    }

    //2.commit
    public RegisterResponceDto registerMapperNotDuplicateEmail(RegisterRequestDto dto) {
        User user = UserMapper.INSTANCE.fromRegisterRequestDtoToUser(dto);
        if(!user.getPassword().equals(user.getRePassword()) || user.getPassword().isBlank()) {
            throw new RuntimeException("Şifreler aynı değildir");
        }
        Optional<User> user1 =userRepository.findByEmail(dto.getEmail());
        if(user1.isPresent()){
            throw new RuntimeException("Kayıtlı email ile ikinci kez kayıt yapılamaz. Başka bir email deneyiniz.");
        }
        if(dto.getEmail().equals(("ba.admin@email.com"))){
            user.setStatus(EStatus.ACTIVE);
            user.setUserType(EUserType.ADMIN);
        }
            userRepository.save(user);
        return UserMapper.INSTANCE.fromUserToRegisterResponceDto(user);
    }

    public List<User> findAllByOrderByName(){
        return userRepository.findAllByOrderByName();
    }


    public Boolean existsByNameIgnoreCase(String name) {
        return userRepository.existsByNameIgnoreCase(name);
    }

    public List<User> findAllByNameContainingIgnoreCase(String name) {
        return userRepository.findAllByNameContainingIgnoreCase(name);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    //3.commit
    public List<User> findUsersWithLongPasswordNative(Integer length) {
        return userRepository.findUsersWithLongPasswordNative(length);
    }

    public List<User> findUsersWithLongPasswordJPQL(int passwordLength) {
        return userRepository.findUsersWithLongPasswordJPQL(passwordLength);
    }

    public List<User> findAllByEmailEndsWithIgnoreCase(String name) {
        return userRepository.findAllByEmailEndsWithIgnoreCase(name);
    }


}
