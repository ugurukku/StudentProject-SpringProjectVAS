package com.example.demospring.serviceImpl;


import com.example.demospring.dto.RegisterRequest;
import com.example.demospring.dto.UserRequestResponse;
import com.example.demospring.dto.UserPageResponse;
import com.example.demospring.entity.User;
import com.example.demospring.exception.UserNotFoundException;
import com.example.demospring.mapper.UserMapper;
import com.example.demospring.repository.UserRepository;
import com.example.demospring.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper mapper;

    private final PasswordEncoder encoder;


    @Override
    public UserPageResponse getAll(int page, int count) {

        Page<User> userPage = userRepository.findAll(PageRequest.of(page, count));


        return new UserPageResponse(
                userPage.getContent().stream().map(mapper::toUserDto).toList(),
                userPage.getTotalElements(),
                userPage.getTotalPages(),
                userPage.hasNext()
        );
    }

    @Override
    public UserRequestResponse getById(int id) {
        return userRepository.findById(id)
                .stream()
                .map(mapper::toUserDto)
                .findFirst()
                .orElseThrow(()->new UserNotFoundException("User tapilmadi"));

    }

    @Override
    public User saveUser(UserRequestResponse dto) {
        return userRepository.save(mapper.toEntity(dto));
    }

    @Override
    public void deleteUser(int id) {
       userRepository.deleteById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository
                .findUserByEmail(email)
                .orElseThrow(()->new UserNotFoundException("User tapilmadi"));
    }

    @Override
    public void register(RegisterRequest request) {
        User user = mapper.toUserFromRegisterRequest(request);
        user.setPassword(encoder.encode(request.password()));
        userRepository.save(user);
    }

}
